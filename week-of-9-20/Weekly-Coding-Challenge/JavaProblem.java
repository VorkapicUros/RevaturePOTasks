public class JavaProblem {
    public static void main(String[] args) {
        JavaProblem jp = new JavaProblem();
        System.out.println("32GB --> " + jp.actualMemorySize("32GB"));
        System.out.println("2GB --> " + jp.actualMemorySize("2GB"));
        System.out.println("512MB --> " + jp.actualMemorySize("512MB"));
        System.out.println("1GB --> " + jp.actualMemorySize("1GB"));
    }

    public String actualMemorySize(String mem) {
        String byteSize = mem.substring(mem.length() - 2, mem.length());
        double bytes = ((double) Integer.parseInt(mem.substring(0, mem.length() - 2))) * .93;
        if (byteSize.equals("GB") && bytes < 1) {
            byteSize = "MB";
            bytes *= 1024;
        }
        if (byteSize.equals("MB"))
            return (int) bytes + byteSize;
        else
            return ((double) Math.round(bytes*100)/100) + byteSize;
    }
}