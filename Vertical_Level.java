import java.io.*;
import java.util.*;

public class Vertical_Level{

    static class Arbol{
        public Arbol Izq;
        public Arbol Der;
        public int Valor;
        public Arbol(int V){
            Valor = V;
            Izq = Der = null;
        }
    }

    static Arbol Push(Arbol Raiz,int Valor){
        if (Raiz == null){
            Raiz = new Arbol(Valor);
        }
        else if(Raiz.Valor > Valor){
            Raiz.Izq = Push(Raiz.Izq,Valor);
        }
        else if (Raiz.Valor < Valor){
            Raiz.Der = Push(Raiz.Der,Valor);
        }
        return Raiz;
    }

    static void GenerateVertical(Arbol Raiz, int llave, TreeMap<Integer,Vector<Integer>> mapa){
        if (Raiz != null){
            Vector<Integer> V = mapa.get(llave);
            if (V == null){
                V = new Vector<Integer>();
                V.add(Raiz.Valor);
                mapa.put(llave,V);
            }
            else V.add(Raiz.Valor);
            GenerateVertical(Raiz.Izq,llave-1,mapa);
            GenerateVertical(Raiz.Der,llave+1,mapa);
        }
    }

    public static void main(String[] args){
        TreeMap<Integer,Vector<Integer>> mapa = new TreeMap<Integer,Vector<Integer>>();
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Arbol Raiz = null;
        for(int i=0;i<N;i++){
            Raiz = Push(Raiz,input.nextInt());
        }
        GenerateVertical(Raiz,0,mapa);
        for(Vector<Integer> V : mapa.values()){
            for(int i=0;i<V.size();i++){
                if (i==0) System.out.print(V.elementAt(i));
                else System.out.print(" "+V.elementAt(i));
            }
            System.out.println("");
        }
    }
}