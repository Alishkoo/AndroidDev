package com.example.dodoapp

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable


data class ItemsViewModel(val image: Int, val Nametext: String, val DescText: String, val ButtonText: String) :
    Parcelable {
    // Добавьте необходимые методы Parcelable здесь

    // Пример методов для Parcelable
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(image)
        dest.writeString(Nametext)
        dest.writeString(DescText)
        dest.writeString(ButtonText)
    }

    companion object CREATOR : Parcelable.Creator<ItemsViewModel> {
        override fun createFromParcel(parcel: Parcel): ItemsViewModel {
            return ItemsViewModel(parcel)
        }

        override fun newArray(size: Int): Array<ItemsViewModel?> {
            return arrayOfNulls(size)
        }
    }

    private constructor(parcel: Parcel) : this(
        image = parcel.readInt(),
        Nametext = parcel.readString() ?: "",
        DescText = parcel.readString() ?: "",
        ButtonText = parcel.readString() ?: ""
    )
}

