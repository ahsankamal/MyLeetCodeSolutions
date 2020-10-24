package WeekTwo;


public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {

        String[] vr1 = version1.split("\\.");
        String[] vr2 = version2.split("\\.");

        int[] v1 = new int[vr1.length];
        int[] v2 = new int[vr2.length];

        for(int i=0;i<v1.length;i++){
            if(vr1.length>0){
                vr1[i] = vr1[i].replaceFirst("^0+", "");
                if(vr1[i].length()==0){
                    v1[i]=0;
                }else{
                    v1[i]=Integer.parseInt(vr1[i]);
                }
            }else {
                v1[i]=Integer.parseInt(vr1[i]);
            }

        }
        for(int i=0;i<v2.length;i++){
            if(vr1.length>0){
                vr2[i] = vr2[i].replaceFirst("^0+", "");
                if(vr2[i].length()==0){
                    v2[i]=0;
                }else{
                    v2[i]=Integer.parseInt(vr2[i]);
                }
            }else{
                v2[i]=Integer.parseInt(vr2[i]);
            }

        }
        if(v1.length>v2.length){
            int i=0;
            for(i=0;i<v1.length;i++){
                if(i>=v2.length){
                    if(v1[i]!=0){
                        return 1;
                    }continue;
                }
                if(v1[i]>v2[i]){
                    return 1;
                }else if(v1[i]<v2[i]){
                    return -1;
                }
            }
            if(i==v1.length){
                return 0;
            }
        }else{
            int i=0;
            for(i=0;i<v2.length;i++){
                if(i>=v1.length){
                    if(v2[i]!=0){
                        return -1;
                    }continue;
                }
                if(v1[i]>v2[i]){
                    return 1;
                }else if(v1[i]<v2[i]){
                    return -1;
                }
            }
            if(i==v2.length){
                return 0;
            }
        }
        return 0;
    }


    public static void main(String[] args){
        CompareVersionNumbers c = new CompareVersionNumbers();
//        System.out.println(c.compareVersion("0.1", "1.1"));
//        System.out.println(c.compareVersion("1.0.1", "1"));
//        System.out.println(c.compareVersion("7.5.2.4", "7.5.3"));
//        System.out.println(c.compareVersion("1.01", "1.001"));
//        System.out.println(c.compareVersion("1.0", "1.0.0"));
        System.out.println(c.compareVersion("1.0", "1.2"));
        System.out.println(c.compareVersion("1.2", "1.10"));
    }
}
