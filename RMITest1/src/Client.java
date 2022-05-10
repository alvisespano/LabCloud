import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

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

"Person[name=\"Davi\;de\";surname=\"Volpe\";age=int[00000018]]"

"{ type: Person, content: { name: \"Davide\", surname: \"Volpe\", age: 24 } }"

"<object type=\"Person\"><field name=\"name\">Davide</field>  <field name=\"surname\">Volpe</field>    </object>"

public class Client {

    public static void main(String[] args) {
        try {
            MyRemote srv = (MyRemote) Naming.lookup("rmi://localhost:5000/sqrt");

            Person davide = new Person("Davide", "Volpe", 24);
            Person olderDavide = srv.makeOlder(davide, 10);

            switch (args.length) {
                case 0:
                    System.out.printf("USAGE: java %s <FLOAT>\n\n", Client.class.getName());
                    break;

                case 1: {
                    double x = Double.parseDouble(args[0]);
                    double result = srv.calculateSquareRoot(x);
                    System.out.printf("sqrt(%g) = %g\n", x, result);
                    break;
                }

                case 2: {
                    double a = Double.parseDouble(args[0]);
                    double b = Double.parseDouble(args[1]);
                    double result = srv.calculatePythagorean(a, b);
                    System.out.printf("pythagorean(%g, %g) = %g\n", a, b, result);
                    break;
                }

            }
        } catch (RemoteException | MalformedURLException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
