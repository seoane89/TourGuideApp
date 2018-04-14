package com.example.android.tourguideapp;

/**
 * Created by ti6a on 13-Apr-18.
 */
// Place is a custom java object which contains information about a PLACE we want to show to the user,
// be it a museum, landmark, shopping destination or a party place
// the Place Object could contain Name, Working Times, Picture ID, Map ID, Information
public class Place {
    /**
     * Constant value that represents no image was provided for this Place
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    // Name of the Place
    private String mPlaceName;
    // Work times of the Place
    private String mPlaceWorkTime;
    // Picture Resourse ID of the Place
    private int mPlacePictureResID = NO_IMAGE_PROVIDED;
    // Map ID
    //TODO Figure how to put map into the app to show where the PLACE is
    // Information about the Place
    private String mPlaceInformation;

    public Place(String placeName, String placeWorkTime,  int placePictureResID, String placeInformation) {
        mPlaceName = placeName;
        mPlaceWorkTime = placeWorkTime;
        mPlacePictureResID = placePictureResID;
        mPlaceInformation = placeInformation;
    }

    public String getPlaceName() {
        return mPlaceName;
    }

    public String getPlaceWorkTime() {
        return mPlaceWorkTime;
    }

    public int getPlacePictureResID() {
        return mPlacePictureResID;
    }

    public String getPlaceInformation() {
        return mPlaceInformation;
    }
    /**
     * Returns whether or not there is an image for this place.
     */
    public boolean hasImage() {
        return mPlacePictureResID != NO_IMAGE_PROVIDED;
    }
}