package com.teamtreehouse.hibernate;

/**
 * Created by leonardo on 10.04.2016.
 */
public class Contact
{
    private int mId;
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private int mPhone;

    public Contact(String firstName, String lastName, String email, int phone)
    {
        mFirstName = firstName;
        mLastName = lastName;
        mEmail = email;
        mPhone = phone;
    }

    public int getId()
    {
        return mId;
    }

    public void setId(int id)
    {
        mId = id;
    }

    public String getFirstName()
    {
        return mFirstName;
    }

    public void setFirstName(String firstName)
    {
        mFirstName = firstName;
    }

    public String getLastName()
    {
        return mLastName;
    }

    public void setLastName(String lastName)
    {
        mLastName = lastName;
    }

    public String getEmail()
    {
        return mEmail;
    }

    public void setEmail(String email)
    {
        mEmail = email;
    }

    public int getPhone()
    {
        return mPhone;
    }

    public void setPhone(int phone)
    {
        mPhone = phone;
    }

    @Override
    public String toString()
    {
        return "Contact{" +
            "mId=" + mId +
            ", mFirstName='" + mFirstName + '\'' +
            ", mLastName='" + mLastName + '\'' +
            ", mEmail='" + mEmail + '\'' +
            ", mPhone=" + mPhone +
            '}';
    }
}
