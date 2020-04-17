import javax.swing.JOptionPane;
public class CSC402
{
	public static void main(String[] args)
	{
    String optionInput;
    int option;
    optionInput = JOptionPane.showInputDialog("Search by what?(Enter Number 1-6)\n1. Genre\n2. Title\n3. Artist\n4. Length\n5. Album\n6. Year");
    option = Integer.parseInt(optionInput);
    while(0 < option && option < 7)
    {
      if (option == 1)
      {
        String genreYN1;
        char genreYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Genre")
        genreYN1 = JOptionPane.showInputDialog("Searching by Genre? (Y or N)");
        genreYN2 = genreYN1.charAt(0);
        if (genreYN2==('Y')||genreYN2==('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (genreYN2 == 'N'||genreYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error");
        }
      }//Option 1 End
      else if (option == 2)
      {
        String TitleYN1;
        char TitleYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Title")
        TitleYN1 = JOptionPane.showInputDialog("Searching by Title? (Y or N)");
        TitleYN2 = TitleYN1.charAt(0);
        if (TitleYN2 == ('Y')||TitleYN2 == ('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (TitleYN2 == 'N'||TitleYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error");
        }
      }//Option 2 End
      else if (option == 3)
      {
        String ArtistYN1;
        char ArtistYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Artist")
        ArtistYN1 = JOptionPane.showInputDialog("Searching by Artist? (Y or N)");
        ArtistYN2 = ArtistYN1.charAt(0);
        if (ArtistYN2 == ('Y') || ArtistYN2 == ('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (ArtistYN2 == 'N'||ArtistYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error");
        }
      }//Option 3 End
      else if (option == 4)
      {
        String LengthYN1;
        char LengthYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Length")
        LengthYN1 = JOptionPane.showInputDialog("Searching by Length? (Y or N)");
        LengthYN2 = LengthYN1.charAt(0);
        if (LengthYN2==('Y')||LengthYN2==('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (LengthYN2 == 'N'||LengthYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error");
        }
      }//Option 4 End
      else if (option == 5)
      {
        String AlbumYN1;
        char AlbumYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Album")
        AlbumYN1 = JOptionPane.showInputDialog("Searching by Album? (Y or N)");
        AlbumYN2 = AlbumYN1.charAt(0);
        if (AlbumYN2 == ('Y')||AlbumYN2 == ('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (AlbumYN2 == 'N'||AlbumYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error");
        }
      }//Option 5 End
      else if (option == 6)
      {
        String YearYN1;
        char YearYN2;
        //JOptionPane.showMessageDialog(null, "Searching by Year")
        YearYN1 = JOptionPane.showInputDialog("Searching by Year? (Y or N)");
        YearYN2 = YearYN1.charAt(0);
        if (YearYN2 == ('Y') || YearYN2 == ('y'))
        {
          JOptionPane.showMessageDialog(null, "Yes");
        }
        else if (YearYN2 == 'N'||YearYN2 == 'n')
        {
          JOptionPane.showMessageDialog(null, "No");
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Error");
        }
      }//Option 6 End
    }//While loop 1-6 End
  }//Main End
}//Program End
