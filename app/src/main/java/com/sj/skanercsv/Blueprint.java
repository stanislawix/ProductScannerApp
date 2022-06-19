package com.sj.skanercsv;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Blueprint {

    @NonNull
    private String name;

    public Blueprint(@NonNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blueprint that = (Blueprint) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
