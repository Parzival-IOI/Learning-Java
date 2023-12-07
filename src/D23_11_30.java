import java.util.HashMap;
import java.util.Map;


public class D23_11_30 {
    public static void main(String[] args) {
        // String str1= "idNumber: 160363311";
        // String str2= "dob: 01/01/1995";
        // String str3= "gender: M";
        // String str4= "lastNameEn: MEN";
        // String str5= "firstNameEn: CHENDA";
        // String str6= "expiredDate: 21/06/2024";
        
        String ss = "IDKHM1603633111<<<<<<<<<<<<<<<,9501016M2406215KHM<<<<<<<<<<<6,MEN<<CHENDA<<<<<<<<<<<<<<<<<<<";



        // System.out.println(ex1(str1));
        // System.out.println(ex1(str2));
        // System.out.println(ex1(str3));
        // System.out.println(ex1(str4));
        // System.out.println(ex1(str5));
        // System.out.println(ex1(str6));


        // String s[] = ex2(ss);
        // for(String sss:s) {
        //     System.out.println(sss);
        // }
            

        Map<String, String> egg = ex2_test(ss);
        for (Map.Entry<String,String> entry : egg.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
            
    }

    public static String ex1(String str) {
        return (str.substring(str.indexOf(":") + 2, str.length()));
    }

    public static String[] ex2(String str) {
        String[] s = new String[6];
        String temp;

        //ID
        s[0] = str.substring(5,14);

        //DOB
        temp = str.substring(str.indexOf(",")+1, str.indexOf(",")+1+6);
        s[1] = temp.substring(4,6) + "/" + temp.substring(2,4) + "/" + temp.substring(0,2);

        //Sex
        s[2] = str.substring(str.indexOf(",")+8, str.indexOf(",")+9);

        //Expire
        temp = str.substring(str.indexOf(",")+9, str.indexOf(",")+15);
        s[5] = temp.substring(4,6) + "/" + temp.substring(2,4) + "/" + temp.substring(0,2);
    
        //First Name
        temp = str.substring(str.indexOf(",")+32, str.length());
        s[3] = temp.substring(0,temp.indexOf("<"));

        // Second Name
        String temp2 = temp.substring(temp.indexOf("<")+2, temp.length());
        s[4] = temp2.substring(0, temp2.indexOf("<"));


        return s;
    }
    public static Map<String, String> ex2_test(String str) {
        StringBuilder SB = new StringBuilder();
        Map<String, String> s = new HashMap<>();
        String[] temp = str.split(",");
        String temp1;

        s.put("ID",temp[0].substring(5, temp[0].indexOf("<")-1));
        
        temp1 = temp[1].substring(0,6);
        s.put("DOB", SB.append(temp1.substring(4,6)).append("/").append(temp1.substring(2, 4)).append("/").append(temp1.substring(0,2)).toString());

        s.put("Sex",temp[1].substring(7,8));

        temp1 = temp[1].substring(8,14);
        SB.delete(0, SB.length());
        s.put("Expire",SB.append(temp1.substring(4,6)).append("/").append(temp1.substring(2, 4)).append("/").append(temp1.substring(0,2)).toString());
        
        s.put("First Name",temp[2].substring(0, temp[2].indexOf("<")));

        s.put("Last Name",temp[2].substring(temp[2].indexOf("<") + 2, temp[2].length()).substring(0, temp[2].substring(temp[2].indexOf("<") + 2, temp[2].length()).indexOf("<")));

        return s;
    }
}
