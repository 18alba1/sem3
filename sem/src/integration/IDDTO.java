package integration;

public class IDDTO 
{
    private int socialSecurity;
    private String name;
    private int dateOfBirth;

    public IDDTO (int socialSecurity, String name, int dateOfBirth)
    {
        this.socialSecurity = socialSecurity;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getSocialSecurity ()
    {
        return socialSecurity;
    }

    public void setSocialSecurity (int newSocialSecurity)
    {
        socialSecurity = newSocialSecurity;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String newName)
    {
        name = newName;
    }

    public int getDateOfBirth ()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth (int newDateOfBirth)
    {
        dateOfBirth = newDateOfBirth;
    }
}
