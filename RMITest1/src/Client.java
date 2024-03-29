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

            Student pippo = new Student("Pippo", 30);
            System.out.printf("pippo: %s\n", pippo);
            pippo = srv.makeOlder(pippo);
            System.out.printf("pippo: %s\n", pippo);

        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
