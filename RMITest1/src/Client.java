import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class Client {


    public static void main(String[] args) {
        if (args.length >= 1) {
            double x = Double.parseDouble(args[0]);

            try {
                MyRemoteService srv = (MyRemoteService) Naming.lookup(/*MyRemoteService.rmiURI*/"test");

                double result = srv.calculateSquareRoot(x);
                System.out.println(result);

                // example 2
                Person p = new Person("Mario", "Rossi", "Viale Garibaldi", 80);
                int age = srv.getPersonAge(p);
                Student s = new Student("Gigi", "Proietti", "Via col vento", 90);
                Student s2 = srv.makeOlder(s, 10);
                System.out.println(String.format("age = %d", age));

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
