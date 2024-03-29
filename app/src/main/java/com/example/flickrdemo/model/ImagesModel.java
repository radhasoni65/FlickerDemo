package com.example.flickrdemo.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImagesModel extends BaseModel {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("generator")
    @Expose
    private String generator;
    @SerializedName("items")
    @Expose
    public List<ItemModel> items = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }








    public class ItemModel {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("media")
        @Expose
        private MediaModel media;
        @SerializedName("date_taken")
        @Expose
        private String dateTaken;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("published")
        @Expose
        private String published;
        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("author_id")
        @Expose
        private String authorId;
        @SerializedName("tags")
        @Expose
        private String tags;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public MediaModel getMedia() {
            return media;
        }

        public void setMedia(MediaModel media) {
            this.media = media;
        }

        public String getDateTaken() {
            return dateTaken;
        }

        public void setDateTaken(String dateTaken) {
            this.dateTaken = dateTaken;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPublished() {
            return published;
        }

        public void setPublished(String published) {
            this.published = published;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthorId() {
            return authorId;
        }

        public void setAuthorId(String authorId) {
            this.authorId = authorId;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }
    }
    public class MediaModel {
        @SerializedName("m")
        @Expose
        private String m;

        public String getM() {
            return m;
        }

        public void setM(String m) {
            this.m = m;
        }

    }


}
