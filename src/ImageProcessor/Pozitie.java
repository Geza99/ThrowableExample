package ImageProcessor;

/*  O clasa  numita  Pozitie  care  controleaza  pozitia  unui  punct  in  spatiu  (denumire  punct  (String),  coordonatele  pe
axele  X,  Y,  Z  (valori  intregi),  constructori,  accesori,  mutatori).  Se  declara  un  tablou  de  maxim  3  obiecte  de  tip  Pozitie  dupa
care  utilizatorul  este  solicitat  sa  introduca  numarul  dorit  de  obiecte.  In  secventa  de  initializare  a  datelor  prin  citire  de  la
tastatura  se  trateaza  exceptia  de  tip  ArrayIndexOutOfBoundsException  data  de  introducerea  unui  numar  incorect  de
obiecte.
Se  testeaza  coordonatele  tuturor  punctelor  introduse,  iar  daca  oricare  dintre  acestea  sunt  prea  aproape  de  un  alt  punct
cu  coordonatele  predefinite  in  program  (distanta  <  valoare  definita  prin  program),  se  lanseaza  o  exceptie  de  tip
PunctPreaAproape.  In  blocul  catch  aferent  utilizatorul  este  solicitat  sa  reintroduca  repetitiv  coordonatele  obiectului  pana
cand  datele  furnizate  corespund  criteriului.
*/

import  java.util.Scanner;
class  Pozitie
{
    String  nume;
    int  x,y,z;

    Pozitie()
    {
        System.out.print("\nConstructor:  ");
        this.nume=null;
        this.x=0;
        this.y=0;
        this.z=0;
    }
    void  setpoint(String  n,int  a,int  b,int  c)  throws  ArrayIndexOutOfBoundsException,NegativeArraySizeException
    {
        this.nume=n;
        this.x=a;
        this.y=b;
        this.z=c;
    }

    String  getnume()
    {
        return  nume;
    }
    int  getX()
    {
        return  x;
    }
    int  getY()
    {
        return  y;
    }
    int  getZ()
    {
        return  z;
    }
    void  distanta(int  n,int  x1,int  y1,int  z1)  throws  PreaAproape
    {
        if((x-x1<3)  ||  (y-y1<3)  ||  (z-z1<3))
            throw  new  PreaAproape();
        else
            System.out.print("\nDistance  accepted!");

    }
    public  static  void  main(String[]  args)
    {
        Scanner  scan=new  Scanner(System.in);
        int  n,x,y,z;
        String  nume;
        Pozitie[]  p=new  Pozitie[3];
        for(int  i=0;i<3;i++)
        {
            p[i]=new  Pozitie();
        }
        try
        {
            System.out.print("\nNumber  of  positions:  ");
            n=scan.nextInt();
            Pozitie[]  poz=new  Pozitie[n];
            for(int  i=0;i<n;i++)
            {
                poz[i]=new  Pozitie();
            }
            for(int  i=0;i<n;i++)
            {
                boolean  b=true;
                System.out.print("\nName:  ");
                nume=scan.next();
                System.out.print("\nX-Y-Z  position:  ");
                x=scan.nextInt();
                y=scan.nextInt();
                z=scan.nextInt();
                poz[i].setpoint(nume,  x,  y,  z);
                try
                {
                    poz[i].distanta(n,  1,0,  0);
                }
                catch(PreaAproape  pr)
                {
                    b=false;
                    pr.printStackTrace();
                }
                if(!b)
                    i--;
            }

        }
        catch(NegativeArraySizeException  e)
        {
            System.out.print("\nInvalid  number!");
        }


    }
}
