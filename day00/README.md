# Day 00: Getting set up + Interfaces

## TODO before day00 (January 17, 2017)
1. Set up IntelliJ (or use your existing favorite IDE) as per instructions below.
- Learn about IntelliJ's debugging tool (this is not required, but it will tremendously help with debugging, and is much preferred over abusing `System.out.println()`). Become at least acquainted with breakpoints, the `Debug` button, the `Variables` window, and the `Step Over`, `Step Into` and `Step Out` buttons.
- Follow instructions under **Getting started with the code** to make sure you got IntelliJ running. Then read instructions inside `HelloWorld.java` to play around with IntelliJ's debugging tool.
- Complete **at least 10 levels** of [this](http://learngitbranching.js.org/) Git tutorial.
- Join our channel `#dsa-17` on Slack.
- Email us at `dsa-instructors@lists.olin.edu` telling us the coolest thing you learnt (about Git or IntelliJ)!

## JRE (Java Runtime Environment)
Check if you have Java installed:

`java -version`

If you get `The program 'java' can be found in the following packages:`, then
install it with:

`sudo apt-get install default-jre`

## JDK (Java Development Kit)

To install the JDK:

`sudo apt-get intall default-jdk`

## Installing IntelliJ

The IDE we recommend for this class is IntelliJ. If you have another preferred
IDE, that's fine. Here's how to install IntelliJ:

- Navigate to https://www.jetbrains.com/idea/download/ and click Download.
- `cd ~/Downloads  # Assuming this is where your browser downloaded the file to`
- `tar -zxvf ideaIC-XX.Y.Z.tar.gz  # put the name of the file here`
- `cd ideaIC-XX.Y.Z  # this is the folder it was unzipped to`
- `./bin/idea.sh  # this runs IntelliJ`
- Set up IntelliJ according to your preferences!

## Getting started with the code

- In IntelliJ, open up the `day00/` project folder.
- If you don't see the Project sidebar on the left, click on `View > Tool Windows > Project`.
- You will most likely have to repeat these steps with each project:
  - If the `.java` files' icons are a red J instead of a blue C, right click on the `src/` folder and click on `Mark Directory As > Sources Root`
  - If you have unrecognized imports, right click on the `lib/` folder and click on `Add as Library`
  - If you see a yellow bar at the top, click on `Setup SDK/JDK` and choose `Java 1.7` or `1.8`
- Now that you're ready, open up `src/HelloWorld.java`. Right click on the `main` method and choose `Run`.
- If you get the error
> Cannot start compilation: the output path is not specified for module "day00".
> Specify the output path in Configure Project.

   Then click on OK. A new window should open. IntelliJ needs you to specify a place for it to dump compiled Java code. On the left sidebar, choose `Project`. The last option, `Project compiler output`, should be empty (which is why it was complaining). Browse to and choose `day00/out/` as the compiler output folder. If that folder does not exist, simply `cd` into the `day00` directory, and execute `mkdir out/`. Run `main` again.
- If it executes, congratulations!

## Git

- Install Git: either with `Homebrew` (Mac) or with this [tutorial](https://www.digitalocean.com/community/tutorials/how-to-install-git-on-ubuntu-14-04) (Ubuntu). You can also find instructions [here](https://gist.github.com/benkahle/892fdb2531c5f388296a) which are specific to Olin laptops.
