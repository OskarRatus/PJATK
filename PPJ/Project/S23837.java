package projectFin;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public
    class S23837 {

    public static void main(String[] args) {
        // CARGO DICTIONARY
        String[] generalCargo = {"tv", "clothes", "sth"};
        String[] liquids = {"water", "beer", "OJ"};
        String[] frozen = {"food", "medicine"};
        String[] chilled = {"food", "cosmetics"};
        String[] big = {"vehicles", "machines"};
        TEU[] cntr = new TEU[15000];


        //=======================================================================
        // CREATE RANDOM CONTAINERS
        //=======================================================================
        int rnd;
        for(int i = 0; i < cntr.length; i++) {
            rnd = (int) (Math.random() * 10);

            switch (rnd % 6) {
                case 0:
                    cntr[i] = new TEU(((rnd * 1388) + 13880), generalCargo[rnd % generalCargo.length]);
                    break;
                case 1:
                    cntr[i] = new HTC(((rnd * 1265) + 12650), generalCargo[rnd % generalCargo.length]);
                    break;
                case 2:
                    cntr[i] = new REEF(((rnd * 1233) + 12335), frozen[rnd % frozen.length], -rnd);
                    break;
                case 3:
                    cntr[i] = new INSUL(((rnd * 1233) +12335), chilled[rnd % chilled.length], rnd);
                    break;
                case 4:
                    cntr[i] = new FRC(((rnd * 1960) + 19600), big[rnd % big.length]);
                    break;
                case 5:
                    cntr[i] = new TANK(((rnd * 1105) + 11050), liquids[rnd % liquids.length]);
                    break;
            }
        }

//        // CHECK FIRST 5 CONTAINERS
//        System.out.println("GENERATED CONTAINERS =================");
//        for (int i=0; i< 5; i++){
//            System.out.println("#" + i + "\t" + cntr[i].toString());
//        }


        //=======================================================================
        // SAVE ALL CONTAINERS TO TXT
        //=======================================================================
        String path = "C:\\Users\\oskar\\Downloads\\myText.txt";
        try {
            FileWriter fw = new FileWriter(path);
            for (TEU x : cntr){
                fw.write(x.toString());
                fw.write(";");
                fw.flush();
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //=======================================================================
        // CREATE CONTAINERSHIP
        //=======================================================================
        Ship HMMpol = new Ship(20,20,38);


        //======================================================================
        // READ CONTAINERS FROM TXT TO STRING[]
        //=======================================================================
        //==============
        int csvRows = 3;
        //==============

        String[][] list = new String[cntr.length][csvRows];
        read(list, path);

//        // CHECK FIRST 5 READ POSITIONS
//        System.out.println("READ CONTAINERS =================");
//        for (int i=0; i<5;i++){System.out.println(Arrays.toString(list[i]));}

        // PARSE INT
        int[][] tabToSort = new int[list.length][3];
        for(int i=0; i< list.length; i++){
            tabToSort[i][0] = i;
            tabToSort[i][1] = (int) Double.parseDouble(list[i][1]);
        }

//        // CHECK FIRST 5 READ CONTAINERS
//        System.out.println("UNSORTED CONTAINERS =================");
//        for (int i=0; i<5; i++){System.out.println(Arrays.toString(tabToSort[i]));}


        //=======================================================================
        // SORTING
        //=======================================================================
        int[][] tabSorted = bubbleSort(tabToSort);

//        // CHECK FIRST 5 SORTED CONTAINERS
//        System.out.println("SORTED CONTAINERS =================");
//        for (int i=0; i<5; i++){System.out.println(Arrays.toString(tabSorted[i]));}

        // LOAD SORTED CONTAINERS ON SHIP
        int[][] positions = HMMpol.loadCargo(tabSorted);

//        // CHECK ID COMPATIBILITY
//        System.out.println(Arrays.toString(tabSorted[0]));
//        System.out.println(HMMpol.getContainerID(0,9,17));


        //=============================================================================
        // SAVE MANIFESTO TO TXT
        //=============================================================================
        path = "C:\\Users\\oskar\\Downloads\\manifesto.txt";
        try {
            FileWriter fw = new FileWriter(path);
            fw.write("ID\tTIER,ROW,BAY\tWEIGHT\tDESCRIPTION\n");
            for (int i=0; i<15000; i++){
                fw.write("#" + i +"\t");
                fw.write(Arrays.toString(positions[i])+"\t");
                fw.write(list[i][1] + "\t");
                fw.write(list[i][2] + "\t");
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void read(String[][] list, String path){
        try {
            String str = "";
            int i=0, j=0;

            FileReader fr = new FileReader(path);
            int data = fr.read();
            while(data != -1){
                while (data != 59){
                    while (data != 44 && data != 59){
                        str += (char) data;
                        data = fr.read();
                    }
                    list[i][j] = str;
                    str = "";
                    if (data == 59){
                        j=0;
                    } else {
                        j++;
                        data = fr.read();
                    }
                }
                i++;
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] bubbleSort(int[][] tabSort){
        boolean swapped = true;
        int j = 0;
        int[] tmp = new int[2];
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < tabSort.length - j; i++) {
                if (tabSort[i][1] < tabSort[i + 1][1]) {
                    tmp[0] = tabSort[i][0];
                    tmp[1] = tabSort[i][1];

                    tabSort[i][0] = tabSort[i + 1][0];
                    tabSort[i][1] = tabSort[i + 1][1];

                    tabSort[i + 1][0] = tmp[0];
                    tabSort[i + 1][1] = tmp[1];
                    swapped = true;
                }
            }
        }
        return tabSort;
    }
}


class Ship {
    protected int[][][] ship;

    public Ship(int TT, int RR, int BB){
        this.ship = new int[TT][RR][BB];
    }

    public int getContainerID(int TT, int RR, int BB){
        return ship[TT][RR][BB];
    }

    public int[][] loadCargo(int[][] tabSorted){
//                              TT  RR  BB
//     int[][][] ship = new int[20][20][36];
        int[][] positions = new int[tabSorted.length][3];
        int row, bay, tickR, tickB;
        int index=0;
        boolean isFull = false;
        // MAIN STORAGE
        for (int tier=0; tier< ship.length && !isFull; tier++){
            bay = (ship[0][0].length/2) - 1;
            tickB = 1;
            tickR = 1;
            for (int b=0; b< ship[0][0].length && !isFull; b++){
                tickB *= (-1);
                bay += (b * tickB);
                row=(ship[0].length/2)-1;
                for (int r=0; r<ship[0].length && !isFull; r++){
                    tickR *= (-1);
                    row += (r * tickR);
                    this.ship[tier][row][bay] = tabSorted[index][0];
                    positions[tabSorted[index][0]][0] = tier;
                    positions[tabSorted[index][0]][1] = row;
                    positions[tabSorted[index][0]][2] = bay;
                    index++;
                    isFull = (index == tabSorted.length);
                    //System.out.println(tier + " " + row + " " + bay);

                }
            }
        }
        System.out.println("Liczba zaladownych kontenerow: " + index);
        return positions;
    }


}


// CONTAINERS BASED ON STARMARINE SERVICES LTD SPECIFICATION
class TEU{
    // Standard 20' container for general purpose

    protected int length = 6096;            // external length in mm
    protected int width = 2362;             // external width in mm
    protected int height = 2590;            // external height in mm
    protected double tare = 2370;                  // tare weight in kg
    protected double maxPayload = 30130;            // max currLoad in kg

    protected double currLoad;                  // cargo currLoad in kg
    protected String description;           // cargo description

    public TEU(double load, String description){
        this.currLoad = load + this.tare;
        this.description = description;
    }


    @Override
    public String toString() {
        return "TEU" + "," + currLoad + "," + description;
    }

    public String toStringAll(){
        return "TEU{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", tare=" + tare +
                ", maxPayload=" + maxPayload +
                ", currLoad=" + currLoad +
                ", description='" + description + '\'' +
                '}';
    }
}


class HTC extends TEU {
    // Hard top container for heavy or tall cargo and easy packing

    public HTC(double load, String description) {
        super(load, description);
        super.tare = 2590;
        super.maxPayload = 27890;
        super.currLoad = load + this.tare;
    }

    @Override
    public String toString() {
        return "HTC" + "," + currLoad + "," + description;
    }

    public String toStringAll(){
        return "HTC{" +
                "length=" + super.length +
                ", width=" + width +
                ", height=" + height +
                ", tare=" + tare +
                ", maxPayload=" + maxPayload +
                ", currLoad=" + currLoad +
                ", description='" + description + '\'' +
                '}';
    }
}


class REEF extends TEU {
    // Container with integral refrigeration unit for chilled and frozen goods

    protected double temp;

    public REEF(double load, String description, double temp) {
        super(load, description);
        super.tare = 2905;
        super.maxPayload = 27575;
        super.currLoad = load + this.tare;
        this.temp = temp;
    }
    @Override
    public String toString() {
        return "REEF" + "," + currLoad + "," + description;
    }

    public String toStringAll() {
        return "REEF{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", tare=" + tare +
                ", maxPayload=" + maxPayload +
                ", currLoad=" + currLoad +
                ", description='" + description + '\'' +
                ", temp=" + temp +
                '}';
    }
}


class INSUL extends REEF {
    // Container without integral refrigeration unit for chilled and frozen goods

    public INSUL(double load, String description, double temp) {
        super(load, description, temp);
        super.tare = 2905;
        super.maxPayload = 27575;
        super.currLoad = load + this.tare;
    }
    @Override
    public String toString() {
        return "INSUL" + "," + currLoad + "," + description;
    }

    @Override
    public String toStringAll() {
        return "INSUL{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", tare=" + tare +
                ", maxPayload=" + maxPayload +
                ", currLoad=" + currLoad +
                ", description='" + description + '\'' +
                ", temp='" + temp +
                '}';
    }
}


class FRC extends TEU {
    // Flat rack container with a floor high loading capacity for over-weight or over-height cargoes

    public FRC(double load, String description) {
        super(load, description);
        super.tare = 2900;
        super.maxPayload = 42100;
        super.currLoad = load + this.tare;

    }
    @Override
    public String toString() {
        return "FRC" + "," + currLoad + "," + description;
    }


    public String toStringAll() {
        return "FRC{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", tare=" + tare +
                ", maxPayload=" + maxPayload +
                ", currLoad=" + currLoad +
                ", description='" + description + '\'' +
                '}';
    }
}


class TANK extends TEU {
    // Tank containers for liquid cargoes

    public TANK(double load, String description) {
        super(load, description);
        super.tare = 4190;
        super.maxPayload = 26290;
        super.currLoad = load + this.tare;

    }
    @Override
    public String toString() {
        return "TANK" + "," + currLoad + "," + description;
    }


    public String toStringAll() {
        return "TANK{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", tare=" + tare +
                ", maxPayload=" + maxPayload +
                ", currLoad=" + currLoad +
                ", description='" + description + '\'' +
                '}';
    }

}
