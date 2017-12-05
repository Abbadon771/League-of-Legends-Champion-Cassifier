
/**
 * Write a description of class NaiveBayes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class NaiveBayes
{
    
    private String[] specifiedClass;
    private String[] sideClass1;
    private String[] sideClass2;
    private String[] sideClass3;
    private String[] sideClass4;
    private String[] sideClass5;
    private String sample1;
    private String sample2;
    private String sample3;
    private String sample4;
    private String sample5;
    private String cName;

   
    public NaiveBayes(String sC[], String s1[], String s2[], String s3[], String s4[], String s5[])
    {
       specifiedClass = sC;
       sideClass1 = s1;
       sideClass2 = s2;
       sideClass3 = s3;
       sideClass4 = s4;
       sideClass5 = s5;
    }
    
    public void acquireSample(String champName, String a1, String a2, String a3, String a4, String a5)
    {
        sample1 = a1;
        sample2 = a2;
        sample3 = a3;
        sample4 = a4;
        sample5 = a5;
        cName = champName;
    }
    
    public void classifySample()
    {
      double sizeOfYes = specifiedClassSize(specifiedClass, "Yes");
      double sizeOfNo = specifiedClassSize(specifiedClass, "No");
      double probTierYes = specifiedClassProb(specifiedClass, "Yes");
      double probTierNo = specifiedClassProb(specifiedClass, "No");
      double probS1Yes = classProbabilityD(specifiedClass, "Yes", sample1, sideClass1, sizeOfYes);
      double probS1No = classProbabilityD(specifiedClass, "No", sample1, sideClass1, sizeOfNo);
      double probS2Yes = classProbabilityD(specifiedClass, "Yes", sample2, sideClass2, sizeOfYes);
      double probS2No = classProbabilityD(specifiedClass, "No", sample2, sideClass2, sizeOfNo);
      double probS3Yes = classProbabilityD(specifiedClass, "Yes", sample2, sideClass2, sizeOfYes);
      double probS3No = classProbabilityD(specifiedClass, "No", sample3, sideClass3, sizeOfNo);
      double probS4Yes = classProbabilityD(specifiedClass, "Yes", sample4, sideClass4, sizeOfYes);
      double probS4No = classProbabilityD(specifiedClass, "No", sample4, sideClass4, sizeOfNo);
      double probS5Yes = classProbabilityS(specifiedClass, "Yes", sample5, sideClass5, sizeOfYes);
      double probS5No = classProbabilityS(specifiedClass, "No", sample5, sideClass5, sizeOfNo);
      double sampleY = probS1Yes * probS2Yes * probS3Yes * probS4Yes * probS5Yes * probTierYes;
      double sampleN = probS1No * probS2No * probS3No * probS4No * probS5No * probTierNo;
      System.out.println("The probability for the sample being top tier is: " + sampleY);
      System.out.println("The probability for the sample being top tier is: " + sampleN);
      if(sampleY > sampleN)
      {
          System.out.println("The champion " + cName + " in the role of " + sample5);
          System.out.println("With these stats: ");
          System.out.println("Win Rate: " + "%" + sample1);
          System.out.println("Play Rate: " + "%" + sample2);
          System.out.println("Ban Rate: " + "%" + sample3);
          System.out.println("KDA average: " + "%" + sample4);
          System.out.println("Has a high rate of being in the top tier of the current League of Legends Meta");
      }
      else
      {
          System.out.println("The champion " + cName + " in the role of " + sample5);
          System.out.println("With these stats: ");
          System.out.println("Win Rate: " + "%" + sample1);
          System.out.println("Play Rate: " + "%" + sample2);
          System.out.println("Ban Rate: " + "%" + sample3);
          System.out.println("KDA average: " + "%" + sample4);
          System.out.println("Has a small rate of being in the top tier of the current League of Legends Meta");
      }
    }
    
    private double specifiedClassSize(String sCl[], String isTier)
    {
        double count = 0.0;
        for(int i = 0; i < 24; i++)
        {
            if(sCl[i] == isTier)
            {
                count = count + 1.0;
            }
        }
        return count;
    }
    
    private double specifiedClassProb(String sCl[], String isTier)
    {
        double count = 0.0;
        double prob = 0.0;
        for(int i = 0; i < 24; i++)
        {
            if(sCl[i] == isTier)
            {
                count = count + 1.0;
            }
        }
        prob = count / 24.0;
        return prob;
    }
    
    private double classProbabilityD(String sCl[], String isTier, String sample, String arrayS[], double numC)
    {
       double count = 0.0;
       double probab = 0.0;
       for(int i = 0; i < 24; i++)
       {
           if((arrayS[i] == sample) && (sCl[i] == isTier))
           {
               count = count + 1.0;
           }
       }
       probab = count / numC;
       return probab;
    }
    
     private double classProbabilityS(String sCl[], String isTier, String sample, String arrayS[], double numC)
    {
        double count = 0.0;
       double probab = 0.0;
       for(int i = 0; i < 24; i++)
       {
           if((arrayS[i] == sample) && (sCl[i] == isTier))
           {
               count = count + 1.0;
           }
       }
       probab = count / numC;
       return probab;
    }
    

   
}
