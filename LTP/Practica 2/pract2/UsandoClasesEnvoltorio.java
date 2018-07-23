public class UsandoClasesEnvoltorio {
    public static void main(String args[]) {
        // Asignacion a tipos elementales de variables envoltorio
        byte b = new Byte((byte)3); 
        short s = new Short((short)512);
        int i = new Integer(123456); 
        long l = new Long(123456789);
        float f = new Float(12345.67);
        double d = new Double(123456.78912);
        boolean bo = new Boolean(true);
        char ch = new Character('A');
        
        // Escritura de variables elementales ...
        System.out.println("byte b = "+ b);
        System.out.println("short s = "+ s);
        System.out.println("int i = "+ i);
        System.out.println("long L = "+ l);
        
        System.out.println("float f = "+ f);
        System.out.println("double d = "+ d);   
        
        System.out.println("boolean bo = "+ bo);
        System.out.println("char ch = "+ ch); 
        
        System.out.println("\n");
        
        
        // Asignacion a tipos envoltorio de variables elementales
        Byte B = (byte)3; 
        Short S = (short)512;
        Integer I = 123456; 
        Long L = 123456789L;
        Float F = 12345.67F; 
        Double D = 123456.78912;
        Boolean Bo = true;
        Character Ch = 'A';
        
        // Escritura de variables envoltorio ...
        System.out.println("Byte B = "+ B);
        System.out.println("Short S = "+ S);
        System.out.println("Integer I = "+ I);
        System.out.println("Long L = "+ L);
        
        System.out.println("Float F = "+ F);
        System.out.println("Double D = "+ D);   
        
        System.out.println("Boolean Bo = "+ Bo);
        System.out.println("Character Ch = "+ Ch);             
        
        System.out.println("\n");
    }   
}
