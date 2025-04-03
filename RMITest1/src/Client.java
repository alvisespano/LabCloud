import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class Client {

    public static void main(String[] args) {
        try {
            // lookup the server by address, port and name
            MyRemote srv = (MyRemote) Naming.lookup("rmi://localhost:5000/myserver");

            if (args.length < 1)
                System.out.printf("not enough command line arguments.\nUsage:\n\tsqrt <NUMBER>\n\tstore <STRING>\n\tretrieve\n\n");
            else {
                switch(args[0]) {
                    case "sqrt": {
                        double x = Double.parseDouble(args[1]);
                        double result = srv.calculateSquareRoot(x);
                        System.out.printf("sqrt(%g) = %g\n", x, result);
                        break;
                    }

                    case "store": {
                        String s = args[1];
                        srv.store(s);
                        System.out.printf("store(%s)\n", s);
                        break;
                    }

                    case "retrieve": {
                        String s = srv.retrieve();
                        System.out.printf("retrieved: \"%s\"\n", s);
                    }
                }
            }
        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
