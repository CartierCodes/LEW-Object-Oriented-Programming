/******************************************************************************
 * @author Carter Burzlaff
 * 
 * 24 November 2019
 * 
 * Much of this file was used from Eric Pogue's ThunderbirdContact application
 * 
 *****************************************************************************/

class ThunderbirdContact extends HttpRequest implements Runnable {
    private String authorName;
    public String getAuthorName() { return authorName; }

    private String authorEmail;
    public String getAuthorEmail() { return authorEmail; }

    private String firstName;
    public String getFirstName() { return Integer.toString(seatLocation) + " " + firstName; }

    private String lastName;
    public String getLastName() {return lastName; }
    
    private int seatLocation; 
    public int getSeat() { return (seatLocation-1); }

    private String preferredName;
    public String getPreferredName() { return preferredName; }

    private String email;
    public String getEmail() { return email; }

    private String phoneNumber;
    public String getPhoneNumber() { return phoneNumber; }

    private String favoriteHobby;
    public String getFavoriteHobby() { return favoriteHobby; }

    ThunderbirdContact(String urlIn, String nameIn, String emailIn) {
        super(urlIn);

        authorName = nameIn;
        authorEmail = emailIn;
        firstName = "";
        lastName = "";
        seatLocation = 0;
        preferredName = "";
        email = "";
        phoneNumber = "";
        favoriteHobby = "";

        // Todo: Add additional fields. 
        // CJB: Completed
    }

    public Boolean Load() {
        Boolean returnValue = false;
        System.out.println("Loading: " + requestURL);
        if (super.readURL()) {
            Parse(); 
            returnValue = true;
        }

        return returnValue;
    }

    public void Parse() {
        for (String s : urlContent) {
            String[] subString = s.split("\"");

            // Todo: Parse for additional fields. 
            // CJB: Completed
            if (subString.length > 3) {
                if (subString[1].equals("firstName")) {
                    firstName = subString[3];
                }
                if (subString[1].equals("lastName")) {
                    lastName = subString[3];
                }
                if (subString[1].equals("seatLocation")) {
                    try {
                        seatLocation = 0; 
                        if (!subString[3].equals("")) {
                            seatLocation = Integer.parseInt(subString[3]);
                        }
                    } 
                    catch (Exception e) {
                        System.out.println("Exception: " + e);
                    }
                }
                if (subString[1].equals("preferredName")) {
                    preferredName = subString[3];
                }
                if (subString[1].equals("email")) {
                    email = subString[3];
                }
                if (subString[1].equals("phoneNumber")) {
                    phoneNumber = subString[3];
                }
                if (subString[1].equals("favoriteHobby")) {
                    favoriteHobby = subString[3];
                }
            }
        }    
    }

    public void Validate() {
        if (urlContent.size() < 1) {
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: No content loaded\n");
            return; // Returning from the middle of a method is controversial.
        }

        // Todo: Add author's name and email address to failed messages. 
        // CJB: Completed
        if (firstName.length() == 0) {
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: First Name (\"firstName\") required but not found\n" + "File Owner: " +
            authorName + "\n Contact: " + authorEmail + "\n");
            System.out.println(this);
        } else if (lastName.length() == 0) {   
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: Last Name (\"lastName\") required but not found\n" + "File Owner: " +
            authorName + "\nContact: " + authorEmail + "\n");
            System.out.println(this);
        } else {
            System.out.println("Validating: " + requestURL + "... Passed!");
        }
    }

    public String toString() {
        // Todo: Add additional fields to returnString. 
        // CJB: Completed
        String returnString = "firstName: " + firstName + "\n";
        returnString = returnString + "lastName: " + lastName + "\n";
        returnString = returnString + "seatNumber: " + seatLocation + "\n";
        returnString = returnString + "preferredName: " + preferredName + "\n";
        returnString = returnString + "email: " + email + "\n";
        returnString = returnString + "phoneNumber: " + phoneNumber + "\n";
        returnString = returnString + "favoriteHobby: " + favoriteHobby + "\n";
        returnString = returnString + super.toString();

        return returnString;
    }

    public void run() {
        Load();
    }
}