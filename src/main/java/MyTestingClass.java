public class MyTestingClass {
    private int attribute1;
    private int attribute2;

    public MyTestingClass(int attribute1, int attribute2) {
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
    }

    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = prime * result + attribute1;
        result = prime * result + attribute2;
        return result;
    }


}
