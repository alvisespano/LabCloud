
## Laboratory of Cloud Computing @ Ca' Foscari

This is the official repository of the Laboratory course of Cloud Computing, Master degree in Computer Science at the Ca' Foscari University of Venice, Italy.

### Installation

You will need the following software:
- a full Java Developer Kit (JDK) installation, preferably OpenJDK version 18+ (https://openjdk.org/)
- _optionally_ an IDE for Java such as IntelliJ IDEA by Jetbrains (https://www.jetbrains.com/idea/)
- a shell terminal for launching the relevant compiled programs

### Instructions

To compile and run the client-server program proceed as follows.

#### Without an IDE

From a shell terminal:

1. `cd` into the `RMITest1` subfolder
2. Create a directory where to put compiled class files, for example `mkdir out`
3. Compile all java source files via `javac src/*.java -d out/` 
4. Now `cd out` and check whether the directory contains the .class files produced by the compiler
5. To test the client-server program you need to run 2 distinct class files:
	- Launch `java Server` to run the server part. The process never exits and will lock the shell (press Ctrl-C if you want to kill it)
	- In another shell, `cd` into `RMITest1/out` again and launch `java Client` followed by additional arguments.
	- For instance, to test the square root launch `java Client` followed by a number, e.g., `java Client 64`

#### Using IntelliJ

If you are using an IDE like IntelliJ IDEA:

1. Use the `Build Project` button in the `Build` menu. This will make the IntelliJ compiler generate class files in its own folder `RMITest1/out/production/RMITest1`
2. From a shell terminal, `cd` into `RMITest1/out/production/RMITest1` and check whether the directory contains the .class files
3. Follow the instructions at point `5` above replacing the folder name with the correct path.

*Warning:* ensure that the JDK used by IntelliJ is a compatible version with the JDK you installed manually.

### About the RMIRegistry

Servers in Java RMI need to register theirselves at startup and bind to a service name and a port.
This is necessary, as clients would not know how to contact a service otherwise.
Java RMI offers a special program that runs in the background working as a daemon process: `rmiregistry`.
This program is bundled within the JDK and it can be run either explicitly from a shell or spawn programmatically from the code.

If you want to run it from a shell:
- Open a shell terminal and - assuming you installed the JDK already - launch `rmiregistry`. The program is not existing and will lock the shell. It has no output theough, so if you just want to run it on the background without occupying a shell terminal launch it as `rmiregistry &`
- In the server code you need to register the server using the following Java line: 	

	<code>
	Naming.rebind("rmi://localhost:5000/myserver", server);
	</code>

	- port number and URL can be changed

Else, if you want to run the registry in a programmatic way:
- In the server code you need to register the server using the following Java lines:

	<code>
	Registry reg = LocateRegistry.createRegistry(5000);
	reg.rebind("myserver", server);
	</code>

For more information refer to the comments in the source files.