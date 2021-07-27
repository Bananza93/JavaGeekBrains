package ru.geekbrains.algo_and_data_struct.lesson2;

import java.util.Objects;

public class Notebook implements Comparable<Notebook> {

    private final Vendor vendor;
    private final int ramSize;
    private final int price;

    public Notebook(Vendor vendor, int ramSize, int price) {
        if (ramSize < 4 || ramSize > 12 || ramSize % 4 != 0) throw new IllegalArgumentException("RAM size must be between 4 and 12 with step 4 (Passed value: " + ramSize + ")");
        if (price < 500 || price > 1000 || price % 100 != 0) throw new IllegalArgumentException("Price must be between 500 and 1000 with step 100 (Passed value: " + price + ")");
        this.vendor = vendor;
        this.ramSize = ramSize;
        this.price = price;
    }

    public static Notebook[] getNotebooksArray(int notebookAmount) {
        Notebook[] result = new Notebook[notebookAmount];
        Vendor[] tmpVendors = Vendor.values();
        for (int i = 0; i < notebookAmount; i++) {
            Vendor v = tmpVendors[(int) (Math.random() * tmpVendors.length)];
            int rs = (int) (Math.random() * 3 + 1) * 4;
            int p = (int) (Math.random() * 6  + 5) * 100;
            result[i] = new Notebook(v, rs, p);
        }
        return result;
    }

    @Override
    public int compareTo(Notebook o) {
        int result = Integer.compare(this.price, o.price);
        if (result == 0) {
            result = Integer.compare(this.ramSize, o.ramSize);
            if (result == 0) {
                result = Integer.compare(this.vendor.getSortPriority(), o.vendor.getSortPriority());
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return ramSize == notebook.ramSize && price == notebook.price && vendor == notebook.vendor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendor, ramSize, price);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "vendor=" + vendor +
                ", ramSize=" + ramSize +
                ", price=" + price +
                '}';
    }
}
