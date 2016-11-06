# Day 00: Getting set up + Interfaces

## JRE (Java Runtime Environment)
Check if you have Java installed:

`java -version`

If you get `The program 'java' can be found in the following packages:`, then
install it with:

`sudo apt-get install default-jre`

## JDK (Java Development Kit)

To install the JDK:

`sudo apt-get intall default-jdk`

## Installing an IDE

The IDE we recommend for this class is IntelliJ. If you have another preferred
IDE, that's fine. Here's how to install IntelliJ:

- Navigate to https://www.jetbrains.com/idea/download/ and click Download.
- `cd ~/Downloads  # Assuming this is where your browser downloaded the file to`
- `tar -zxvf ideaIC-XX.Y.Z.tar.gz  # put the name of the file here`
- `cd ideaIC-XX.Y.Z  # this is the folder it was unzipped to`
- `./bin/idea.sh  # this runs IntelliJ`
- Set up IntelliJ according to your preferences!

## Getting started with the code

Modify `ListClientExample` to use an ArrayList instead of a LinkedList.
