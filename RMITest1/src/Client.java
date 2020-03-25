import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class Client {
    public static void main(String[] args) {
        if (args.length >= 1) {
            double x = Double.parseDouble(args[0]);

            try {
                SquareRoot server = (SquareRoot) Naming.lookup(SquareRoot.name);

                double result = server.calculateSquareRoot(x);
                System.out.println(result);

                Person p = new Person("Pippo", "Baudo", "Via col vento", 80);
                int age = server.getPersonAge(p);
                System.out.println(String.format("age = %d", age));

                p = server.makeOlder(p, 10);
                System.out.println(p);


            } catch (NotBoundException | RemoteException | MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            usage();
        }
    }

    private static void usage() {
        System.out.println(String.format("USAGE: java %s <FLOAT>", Client.class.getName()));
    }
}
