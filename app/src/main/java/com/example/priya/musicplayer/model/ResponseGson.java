package com.example.priya.musicplayer.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseGson {

        @SerializedName("Groups")
        @Expose
        private List<Group> Groups = new ArrayList<Group>();

        /**
         *
         * @return
         * The Groups
         */
        public List<Group> getGroups() {
            return Groups;
        }

        /**
         *
         * @param Groups
         * The Groups
         */
        public void setGroups(List<Group> Groups) {
            this.Groups = Groups;
        }


    public class Group {

        @SerializedName("UniqueId")
        @Expose
        private String UniqueId;
        @SerializedName("Title")
        @Expose
        private String Title;
        @SerializedName("Subtitle")
        @Expose
        private String Subtitle;
        @SerializedName("ImagePath")
        @Expose
        private String ImagePath;
        @SerializedName("Description")
        @Expose
        private String Description;
        @SerializedName("Items")
        @Expose
        private List<Item> Items = new ArrayList<Item>();

        /**
         *
         * @return
         * The UniqueId
         */
        public String getUniqueId() {
            return UniqueId;
        }

        /**
         *
         * @param UniqueId
         * The UniqueId
         */
        public void setUniqueId(String UniqueId) {
            this.UniqueId = UniqueId;
        }

        /**
         *
         * @return
         * The Title
         */
        public String getTitle() {
            return Title;
        }

        /**
         *
         * @param Title
         * The Title
         */
        public void setTitle(String Title) {
            this.Title = Title;
        }

        /**
         *
         * @return
         * The Subtitle
         */
        public String getSubtitle() {
            return Subtitle;
        }

        /**
         *
         * @param Subtitle
         * The Subtitle
         */
        public void setSubtitle(String Subtitle) {
            this.Subtitle = Subtitle;
        }

        /**
         *
         * @return
         * The ImagePath
         */
        public String getImagePath() {
            return ImagePath;
        }

        /**
         *
         * @param ImagePath
         * The ImagePath
         */
        public void setImagePath(String ImagePath) {
            this.ImagePath = ImagePath;
        }

        /**
         *
         * @return
         * The Description
         */
        public String getDescription() {
            return Description;
        }

        /**
         *
         * @param Description
         * The Description
         */
        public void setDescription(String Description) {
            this.Description = Description;
        }

        /**
         *
         * @return
         * The Items
         */
        public List<Item> getItems() {
            return Items;
        }

        /**
         *
         * @param Items
         * The Items
         */
        public void setItems(List<Item> Items) {
            this.Items = Items;
        }

    }
    public class Item {

        @SerializedName("UniqueId")
        @Expose
        private String UniqueId;
        @SerializedName("Title")
        @Expose
        private String Title;
        @SerializedName("Subtitle")
        @Expose
        private String Subtitle;
        @SerializedName("ImagePath")
        @Expose
        private String ImagePath;
        @SerializedName("Description")
        @Expose
        private String Description;
        @SerializedName("Content")
        @Expose
        private String Content;

        /**
         *
         * @return
         * The UniqueId
         */
        public String getUniqueId() {
            return UniqueId;
        }

        /**
         *
         * @param UniqueId
         * The UniqueId
         */
        public void setUniqueId(String UniqueId) {
            this.UniqueId = UniqueId;
        }

        /**
         *
         * @return
         * The Title
         */
        public String getTitle() {
            return Title;
        }

        /**
         *
         * @param Title
         * The Title
         */
        public void setTitle(String Title) {
            this.Title = Title;
        }

        /**
         *
         * @return
         * The Subtitle
         */
        public String getSubtitle() {
            return Subtitle;
        }

        /**
         *
         * @param Subtitle
         * The Subtitle
         */
        public void setSubtitle(String Subtitle) {
            this.Subtitle = Subtitle;
        }

        /**
         *
         * @return
         * The ImagePath
         */
        public String getImagePath() {
            return ImagePath;
        }

        /**
         *
         * @param ImagePath
         * The ImagePath
         */
        public void setImagePath(String ImagePath) {
            this.ImagePath = ImagePath;
        }

        /**
         *
         * @return
         * The Description
         */
        public String getDescription() {
            return Description;
        }

        /**
         *
         * @param Description
         * The Description
         */
        public void setDescription(String Description) {
            this.Description = Description;
        }

        /**
         *
         * @return
         * The Content
         */
        public String getContent() {
            return Content;
        }

        /**
         *
         * @param Content
         * The Content
         */
        public void setContent(String Content) {
            this.Content = Content;
        }

    }
}
