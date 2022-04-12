import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.util.function.Function;

/*#include "mystubs.h"

struct person {
   char* name;
   char* surname;
   int age;
};

int f(int x) {
    return x + 1;
}

person make_older_by__(person p, int n) {
   p.age += n;
   return p;
}

person make_older_by(person p, int n){
        // SERIALIZE argument p
        // SERIALIZE argument n
        // INVOKE make_older_by
        // RECEIVE result
        // DESERIALIZE result
        // RETURN deserialized result
}

void caller() {
    int n = 23;
    int m = f(n);
    person gigi;
    gigi.name = "Gigi";
    gigi.surname = "Rossi";
    gigi.age = 40;
    person older_gigi = make_older_by(gigi, 10);


    person older_gigi = RPC_INVOKE(make_older_by, gigi, 10);
}

 */



public class Client {

    public static void main(String[] args) {
        try {
            MyRemote srv = (MyRemote) Naming.lookup(MyRemote.rmiURI);

            if (args.length != 1) {
                usage();
            }
            else {
                double x = Double.parseDouble(args[0]);
                System.out.printf("sqrt(%g) = %g\n", x, srv.calculateSquareRoot(x));
            }
        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void usage() {
        System.out.printf("USAGE: java %s <FLOAT>\n\n", Client.class.getName());
    }
}
