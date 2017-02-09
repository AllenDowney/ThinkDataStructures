import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class WikiParser {

	// the list of paragraphs we should search
	private Elements paragraphs;

	// the stack of open delimiters
	private Deque<String> parenthesisStack;


	public WikiParser(Elements paragraphs) {
		this.paragraphs = paragraphs;
		this.parenthesisStack = new ArrayDeque<String>();
	}

	public Element findFirstLink() {
		for (Element paragraph: paragraphs) {
			Element firstLink = findFirstLinkPara(paragraph);
			if (firstLink != null) {
				return firstLink;
			}
			if (!parenthesisStack.isEmpty()) {
				System.err.println("Warning: unbalanced parentheses.");
	   	 	}
		}
		return null;
	}

	private Element findFirstLinkPara(Node root) {
		// create an Iterable that traverses the tree
		Iterable<Node> nt = new WikiNodeIterable(root);

		// loop through the nodes
		for (Node node: nt) {
			// process TextNodes to get parentheses
			if (node instanceof TextNode) {
				processTextNode((TextNode) node);
			}
			// process elements to get find links
			if (node instanceof Element) {
		        Element firstLink = processElement((Element) node);
		        if (firstLink != null) {
					return firstLink;
				}
			}
		}
		return null;
	}

	private Element processElement(Element elt) {
		//System.out.println(elt.tagName());
		if (validLink(elt)) {
			return elt;
		}
		return null;
	}

	private boolean validLink(Element elt) {
		// it's no good if it's
		// not a link
		if (!elt.tagName().equals("a")) {
			return false;
		}
		// in italics
		if (isItalic(elt)) {
			return false;
		}
		// in parenthesis
		if (isInParens(elt)) {
			return false;
		}
		// a bookmark
		if (startsWith(elt, "#")) {
			return false;
		}
		// a Wikipedia help page
		if (startsWith(elt, "/wiki/Help:")) {
			return false;
		}
		// TODO: there are a couple of other "rules" we haven't handled
		return true;
	}

	private boolean startsWith(Element elt, String s) {
		return (elt.attr("href").startsWith(s));
	}

	private boolean isInParens(Element elt) {
		return !parenthesisStack.isEmpty();
	}

	private boolean isItalic(Element start) {
		for (Element elt=start; elt != null; elt = elt.parent()) {
			if (elt.tagName().equals("i") || elt.tagName().equals("em")) {
				return true;
			}
		}
		return false;
	}

	private void processTextNode(TextNode node) {
		StringTokenizer st = new StringTokenizer(node.text(), " ()", true);
		while (st.hasMoreTokens()) {
		     String token = st.nextToken();
		     if (token.equals("(")) {
		    	 parenthesisStack.push(token);
		     }
		     if (token.equals(")")) {
		    	 if (parenthesisStack.isEmpty()) {
		    		 System.err.println("Warning: unbalanced parentheses.");
		    	 }
		    	 parenthesisStack.pop();
		     }
		}
	}
}
