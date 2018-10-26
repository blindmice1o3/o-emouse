package HeadFirst.DesignPatterns.Ch11ProxyPattern;
/*
    -----     -----     -----
    PROXY pattern: provides a surrogate or placeholder for another object to control access to it.
    -----     -----     -----

    -The Gumball Machine CEO wants a way to monitor the gumball machines, a way to get a report of the inventory and machine state.
    -We create a GumballMonitor class that retrieves the machine's location, inventory of gumballs, and the current
        machine state and prints them in a nice little report.
    -The monitor output looks good, but the specification wasn't clear; we misinterpreted. He wants to monitor gumball
        machines REMOTELY!
    -We need a remote proxy. The problem is that monitor runs in the same JVM as the gumball machine and the CEO wants
        to sit at his desk and "remotely" monitor the machines! So what if we left our GumballMonitor class as is, but handed
        it a proxy to a remote object?
    -Proxy: a stand in for a real object. In this case, the proxy acts just like it is a Gumball Machine object, but behind
        the scenes it is communicating over the network to talk to the real, remote GumballMachine.
    -Keep the code as is, and we give the monitor a reference to a proxy version of the GumballMachine.
    -We have to make sure that the gumball machine can act as a service and accept requests over the network; we also
        need to give our monitor a way to get a reference to a proxy object, but we've got some great tools already built
        into Java to help us. Java's remote invocation functionality. All we have to do is retrofit our code so that it
        takes advantage of the RMI (remote method invocation).

    -A remote proxy acts as a "local representative to a remote object".
    -What's a "remote object"?
        -It's an object that lives in the heap of different Java Virtual Machine (or more generally, a remote object
        that is running in a different address space).
    -What's a "local representative"?
        -It's an object that you can call local methods on and have them forwarded on to the remote object.

    Remote Method Invocation (RMI):
    -The "client" calls a method on the "client helper" (as if the "client helper" were the actual "service object").
    -The "client helper" isn't really the remote "service object". Although the "client helper" acts like it (because it
        has the same method that the "service object" is advertising), the "client helper" doesn't have any of the actual
        method logic the "client" is expecting. Instead, the "client helper" contacts the server, transfers information
        about the method call (e.g., name of the method, arguments, etc.), and waits for a return from the server.
    -The "service helper" receives the request from the "client helper" (through a Socket connection), unpacks the
        information about the call, and then invokes the real method on the real "service object".
    -So, to the "service object", the call is local. It's coming from the "service helper", not a remote "client".
    -The "service helper" gets the return value from the "service object", packs it up, and ships it back (over a
        Socket's output stream) to the "client helper". The "client helper" unpacks the information and returns the
        value to the "client object".

    How the method call happens:
    1. Client object calls doBigThing() on the client helper object.
    2. Client helper packages up information about the call (arguments, method name, etc.) and ships it over the
        network to the service helper.
    3. Service helper unpacks the information for the client helper, finds out which method to call (and on which object)
        and invokes the real method on the real service object.
    4. The method is invoked on the service object, which returns some result to the service helper.
    5. Service helper packages up information returned from the call and ships it back over the network to the client helper.
    6. Client helper unpackages the returned values and returns them to the client object. To the client object, this was
        all transparent.

    -We have the gist of how remote methods work; now we need to understand how to use RMI to enable remote method invocation.
    -What RMI does for you is build the client and service helper objects, right down to creating a client helper object
        with the same methods as the remote service. The nice thing about RMI is that you don't have to write any of the
        networking or I/O code yourself. With your client, you call remote methods (i.e., the ones the Real Service has)
        just like normal method calls on objects running in the client's own local JVM.
    -RMI also provides all the runtime infrastructure to make it all work, including a lookup service that the client can
        use to find and access the remote objects.
    -There is one different between RMI and local (normal) method calls. Remember that even though to the client it looks
        like the method call is local, the client helper sends the method call across the network. So there is networking
        and I/O. And what do we know about networking and I/O methods? They're risky! They can fail! And so, they throw
        exceptions all over the place. As a result, the client does have to acknowledge the risk.

    RMI Nomenclature:
    -In RMI, the client helper is a "stub"
    -In RMI, the service helper is a "skeleton"

    Steps to make an object into a service that can accept remote calls.
        -In other words, steps needed to take an ordinary object and supercharge it so it can be called by a remote client.
    Also, steps to allow a client to make remote calls.

    Making the Remote service:
    1. Make a "Remote Interface":
        -The remote interface defines the methods that a client can call remotely. It's what the client will use as the
        class type for your service. Both the Stub and actual service will implement this!
    2. Make a "Remote Implementation":
        -This is the class that does the Real Work. It has the real implementation of the remote methods defined in the
        remote interface. It's the object that the client wants to call methods on (e.g., our GumballMachine!).
    3. Generate the "stubs" and "skeletons" using rmic:
        -These are the client and server "helpers". You don't have to create these classes or ever look at the source code
        that generates them. It's all handled automatically when you run the rmic tool that ships with your Java development kit.
    4. Start the "RMI registry" (rmiregistry):
        -The rmiregistry is like the white pages of a phone book. It's where the client goes to get the proxy (the
        client/stub helper object).
    5. Start the "remote service":
        -You have to get the service object up and running. Your service implementation class instantiates an instance
        of the service and registers it with the RMI registry. Registering it makes the service available for clients.



    -----     -----     -----
    PROXY pattern: provides a surrogate or placeholder for another object to control access to it.
    -----     -----     -----
*/
public class TestClassGumballMonitor {
    public static void main(String[] args) {
/*        int count = 0;

        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        count = Integer.parseInt(args[1]);
*/        GumballMachine gumballMachine = new GumballMachine("Los Angeles", 286);

        GumballMonitor monitor = new GumballMonitor(gumballMachine);

        // rest of test code here

        monitor.report();
    }
}
