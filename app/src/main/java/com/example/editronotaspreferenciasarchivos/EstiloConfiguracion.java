package com.example.editronotaspreferenciasarchivos;

import android.os.Parcel;
import android.os.Parcelable;

public class EstiloConfiguracion implements Parcelable {
    private String tamLetra;
    private String colorLetra;
    private String colorFondo;

    public EstiloConfiguracion() {
    }

    protected EstiloConfiguracion(Parcel in) {
        tamLetra = in.readString();
        colorLetra = in.readString();
        colorFondo = in.readString();
    }

    public static final Creator<EstiloConfiguracion> CREATOR = new Creator<EstiloConfiguracion>() {
        @Override
        public EstiloConfiguracion createFromParcel(Parcel in) {
            return new EstiloConfiguracion(in);
        }

        @Override
        public EstiloConfiguracion[] newArray(int size) {
            return new EstiloConfiguracion[size];
        }
    };

    public String getTamLetra() {
        return tamLetra;
    }

    public void setTamLetra(String tamLetra) {
        this.tamLetra = tamLetra;
    }

    public String getColorLetra() {
        return colorLetra;
    }

    public void setColorLetra(String colorLetra) {
        this.colorLetra = colorLetra;
    }

    public String getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(String colorFondo) {
        this.colorFondo = colorFondo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tamLetra);
        parcel.writeString(colorLetra);
        parcel.writeString(colorFondo);
    }
}
