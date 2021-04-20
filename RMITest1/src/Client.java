import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.util.function.Function;

public class Client {

    public static void main(String[] args) {
        try {
            MyRemote srv = (MyRemote) Naming.lookup(MyRemote.rmiURI);
            //MyRemoteService srv2 = LocateRegisty.getRegistry();

            if (args.length >= 1) {
                double x = Double.parseDouble(args[0]);
                System.out.printf("sqrt(%g) = %g\n", x, srv.calculateSquareRoot(x));
            }

            // example 2
            Person p1 = new Person("Mario", "Rossi", "Viale Garibaldi, 31", 52);

            // Mario;Rossi;Viale Garibaldi, 31;

            System.out.printf("person age = %d\n", srv.getPersonAge(p1));

            Student s1 = new Student("Gigi", "Proietti", "Via Col Vento, 77", 83);
            s1 = srv.makeOlder(s1, 10);

            Student.Exam ex1 = s1.new PassedExam("calcolo", 18);
            System.out.printf("student = %s\n", s1);

            Function<Integer, Integer> f = srv.getFunction(7);
            int z = f.apply(8);

        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void usage() {
        System.out.printf("USAGE: java %s <FLOAT>", Client.class.getName());
    }
}
