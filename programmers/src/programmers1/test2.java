package programmers1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {

	public static void main(String[] args) {
		
		
		String skill ="ABC";
		String[] skill_tree = {"ACSB","ABC","DD","A"};
		

		
		int answer = 0;
        String[] sk = new String[skill.length()];
        for(int i = 0; i<skill.length();i++){
            sk[i] = skill.substring(i,i+1);
            System.out.println(sk[i]+""+i);
        }
        
        System.out.println();
        for(int j = 0; j<skill_tree.length;j++) {
        	int flag1 = -1;
        	int resultcode = 100;
        	for(int i = 0; i<sk.length;i++) {
        		
        		int flag2 = skill_tree[j].indexOf(sk[i]);
        		System.out.println(flag2);
        		if(flag2<flag1) {
        			System.out.println("?");
        			resultcode = -100;
        			break;
        		}
        		flag1 = flag2;
        		
        	}
        	if(resultcode==100)answer++;
        }
        
        System.out.println(answer);
        
        
        
        
        
        
        
        
        
        
        
        
        for(int j = 0; j<skill_tree.length;j++) {
        	int flag = -1;
        	int resultcode = 100;
	        for(int i = 0; i<sk.length;i++) {
	        	Pattern pat = Pattern.compile(sk[i]); //A B C
	        	Matcher matcher = pat.matcher(skill_tree[j]);
	        	if(matcher.find()) {
	        		//System.out.println("찾아따"+i);
	        		if(i-flag!=1) {
	        			resultcode=-100;
	        			break;
	        		}else {
	        			flag = i;
	        		}
	        		
	        	}
	        }
	        if(resultcode==100)answer++;
	        
	        
        }
        //System.out.println(answer);
        
        
        
        
        
	}
	
}

    