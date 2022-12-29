package com.example.anonymizer.extractor;

public class UrlExtractor extends RegexExtractor {

    public UrlExtractor() {
        this.regex = "(https?):\\/\\/([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:\\/~+#-]*[\\w@?^=%&\\/~+#-])";
    }

}
