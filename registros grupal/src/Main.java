import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("cuantos productos vas a meter hoy:");
        int limite = sc.nextInt();

        while (limite <= 0) {
            System.out.println("ese numero no sirve, pon uno mayor a cero:");
            limite = sc.nextInt();
        }

        System.out.println("ingresa el dia (1 lunes 2 martes 3 miercoles 4 jueves 5 viernes 6 sabado 7 domingo):");
        int dia = sc.nextInt();

        while (dia < 1 || dia > 7) {
            System.out.println("ese dia no existe, solo del 1 al 7 pon:");
            dia = sc.nextInt();
        }

        int c = 0;

        float sumaiva = 0;
        float sumaimc = 0;
        float sumairt = 0;
        float sumatce = 0;
        float sumatotal = 0;

        int elec = 0;
        int compu = 0;
        int acc = 0;
        int redes = 0;

        String nombreMayor = "";
        float precioMayor = 0;

        while (c < limite) {

            System.out.println("escribe el nombre del producto:");
            String nombre = sc.next();

            System.out.println("pon el precio del producto:");
            float precio = sc.nextFloat();

            while (precio <= 0) {
                System.out.println("no puedes poner cero o negativo, pon un precio bien:");
                precio = sc.nextFloat();
            }

            System.out.println("elige la categoria (1 electronica 2 componentes 3 accesorios 4 redes):");
            int categoria = sc.nextInt();

            while (categoria < 1 || categoria > 4) {
                System.out.println("esa categoria no hay, pon 1 2 3 o 4:");
                categoria = sc.nextInt();
            }

            System.out.println("tiene riesgo? (1 si 0 no):");
            int riesgo = sc.nextInt();

            while (riesgo != 0 && riesgo != 1) {
                System.out.println("solo va 1 o 0:");
                riesgo = sc.nextInt();
            }

            System.out.println("cuanto stock tiene (minimo 1):");
            int stock = sc.nextInt();

            while (stock < 1) {
                System.out.println("no se puede menos de 1, pon de nuevo:");
                stock = sc.nextInt();
            }

            float iva = 0;
            if (categoria != 3) {
                iva = precio * 0.12f;
            }

            float imc = precio * 0.015f;

            float irt = 0;
            if (riesgo == 1) {
                irt = precio * 0.037f;
            }

            float tce = 0;
            if (dia == 6 || dia == 7) {
                tce = precio * 0.02f;
            }

            float preciofinal = precio + iva + imc + irt + tce;

            String nombrecategoria = "";
            if (categoria == 1) {
                nombrecategoria = "electronica";
                elec = elec + 1;
            } else if (categoria == 2) {
                nombrecategoria = "componentes";
                compu = compu + 1;
            } else if (categoria == 3) {
                nombrecategoria = "accesorios";
                acc = acc + 1;
            } else if (categoria == 4) {
                nombrecategoria = "redes";
                redes = redes + 1;
            }

            System.out.println("precio: " + precio);
            System.out.println("iva: " + iva);
            System.out.println("imc: " + imc);
            System.out.println("irt: " + irt);
            System.out.println("tce: " + tce);
            System.out.println("precio final: " + preciofinal);
            System.out.println("categoria: " + nombrecategoria);
            System.out.println("stock: " + stock);

            float ivaTotalProd = iva * stock;
            float imcTotalProd = imc * stock;
            float irtTotalProd = irt * stock;
            float tceTotalProd = tce * stock;
            float totalProd = preciofinal * stock;

            sumaiva = sumaiva + ivaTotalProd;
            sumaimc = sumaimc + imcTotalProd;
            sumairt = sumairt + irtTotalProd;
            sumatce = sumatce + tceTotalProd;
            sumatotal = sumatotal + totalProd;

            if (preciofinal > precioMayor || c == 0) {
                precioMayor = preciofinal;
                nombreMayor = nombre;
            }

            c = c + 1;
        }

        int maxcat = elec;
        int catMayor = 1;

        if (compu > maxcat) {
            maxcat = compu;
            catMayor = 2;
        }
        if (acc > maxcat) {
            maxcat = acc;
            catMayor = 3;
        }
        if (redes > maxcat) {
            maxcat = redes;
            catMayor = 4;
        }

        String nombreCatMayor = "";
        if (catMayor == 1) {
            nombreCatMayor = "electronica";
        } else if (catMayor == 2) {
            nombreCatMayor = "componentes";
        } else if (catMayor == 3) {
            nombreCatMayor = "accesorios";
        } else if (catMayor == 4) {
            nombreCatMayor = "redes";
        }

        System.out.println("resumen del dia:");
        System.out.println("total productos: " + c);
        System.out.println("total iva: " + sumaiva);
        System.out.println("total imc: " + sumaimc);
        System.out.println("total irt: " + sumairt);
        System.out.println("total tce: " + sumatce);
        System.out.println("total ventas: " + sumatotal);
        System.out.println("categoria que mas se registro: " + nombreCatMayor);
        System.out.println("producto mas caro al final: " + nombreMayor + " con " + precioMayor);
    }
}