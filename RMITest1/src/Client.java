import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private enum Item { MAKEUP, LIPSTICK, HANDBAG }

    private static class Woman extends Person {
        private List<Item> items = new ArrayList<>();

        public Woman(String name, String surname, String address, int age) {
            super(name, surname, address, age);
        }

        public void add(Item i) {
            items.add(i);
        }

        @Override
        public int getAge() {
            return super.getAge() - 1;
        }
    }

    public static void main(String[] args) {
        if (args.length >= 1) {
            double x = Double.parseDouble(args[0]);

            try {
                RemoteService srv = (RemoteService) Naming.lookup(RemoteService.rmiURI);

                double result = srv.calculateSquareRoot(x);
                System.out.println(result);

                // second example
//                Person p = new Person("Pippo", "Baudo", "Via col vento", 80);
//                int age = srv.getPersonAge(p);
//                System.out.println(String.format("age = %d", age));
//
//                p = srv.makeOlder(p, 10);
//                System.out.println(p);
//
//                Woman p2 = new Woman("Maria", "Callas", "Via blabla", 50);
//                p2.add(Item.HANDBAG);
//                p2.add(Item.LIPSTICK);
//                p2.add(Item.MAKEUP);
//                p2 = srv.makeOlder(p2, 10);
//                System.out.println(p2);


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
