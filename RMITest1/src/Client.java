import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class Client {

    public static void main(String[] args) {
        try {
            MyRemote srv = (MyRemote) Naming.lookup("rmi://localhost:5000/sqrt");

/*            double x = Double.parseDouble(args[0]);
            double result = srv.calculateSquareRoot(x);
            System.out.printf("sqrt(%g) = %g\n", x, result);*/

            if (args.length < 1) {
                String s = srv.retrieve();
                System.out.println("retrieved: " + s);
            }
            else
                srv.store(args[0]);

        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
