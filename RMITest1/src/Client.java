import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class Client {

    public static void main(String[] args) {
        if (args.length >= 1) {
            double x = Double.parseDouble(args[0]);

            try {
                MyRemoteService srv = (MyRemoteService) Naming.lookup(MyRemoteService.rmiURI);

                double result = srv.calculateSquareRoot(x);
                System.out.println(result);

                // example 2
//                Person p = new Person("Mario", "Rossi", "Viale Garibaldi", 80);
//                int age = srv.getAge(p);
//                System.out.println(String.format("age = %d", age));

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
