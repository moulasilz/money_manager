package com.moulasilz.moneymanager.Adapter.Placeholder;

import android.net.Uri;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaceholderItem(i));
        }
    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaceholderItem createPlaceholderItem(int position) {
        Uri imageUri;
        if (position % 2 != 0){
            imageUri = Uri.withAppendedPath(Uri.EMPTY, "[document, image:1000000348]");
        } else imageUri = null;
        return new PlaceholderItem(String.valueOf(position),
                            "Item " + position,
                                    makeDetails(position),
                                    imageUri);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
    public static void changeImage(String position, Uri imageUri){

        ITEM_MAP.get(position).imageUri = new Uri.Builder().build();
        ITEM_MAP.get(position).imageUri = imageUri;
    }
    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String id;
        public final String content;
        public final String details;
        public Uri imageUri;

        public PlaceholderItem(String id, String content, String details , Uri imageUri) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.imageUri = imageUri;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}