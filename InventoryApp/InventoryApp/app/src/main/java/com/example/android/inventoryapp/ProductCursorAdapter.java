package com.example.android.inventoryapp;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.inventoryapp.data.ProductContract.ProductEntry;

import static com.example.android.inventoryapp.R.id.price;

/**
 * Created by Rk on 26-01-2017.
 */

public class ProductCursorAdapter extends CursorAdapter {

    public ProductCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView priceTextView = (TextView) view.findViewById(price);
        final TextView quantityTextView = (TextView) view.findViewById(R.id.quantity);
        final int productId = cursor.getInt(cursor.getColumnIndexOrThrow(ProductEntry._ID));

        int nameColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_NAME);
        int priceColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_PRICE);
        int quantityColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_QUANTITY);

        String productName = cursor.getString(nameColumnIndex);
        String productPrice = cursor.getString(priceColumnIndex);
        final int productQuantity = cursor.getInt(quantityColumnIndex);

        Button sellButton = (Button) view.findViewById(R.id.sell_button);
        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity_left = productQuantity;
                if (quantity_left <= 0) {
                    Toast.makeText(context, "Out Of Stock", Toast.LENGTH_SHORT).show();
                } else quantity_left = productQuantity - 1;
                ContentValues values = new ContentValues();
                values.put(ProductEntry.COLUMN_PRODUCT_QUANTITY, quantity_left);
                Uri ProductUri = ContentUris.withAppendedId(ProductEntry.CONTENT_URI, productId);
                context.getContentResolver().update(ProductUri, values, null, null);
                quantityTextView.setText(productQuantity + " Still Left In Stock");
            }
        });


        nameTextView.setText("Product Name: " + productName);
        priceTextView.setText("It Costs Rs. " + productPrice);
        quantityTextView.setText(productQuantity + "  Still Left in Stock");

    }


}
