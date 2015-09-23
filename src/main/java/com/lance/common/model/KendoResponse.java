package com.lance.common.model;

import java.util.List;

/**
 * Created by perdonare on 2015/8/16.
 */

public class KendoResponse<T> {
    private int results;
    private int _count;
    private List<T> objects;

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public int get_count() {
        return _count;
    }

    public void set_count(int _count) {
        this._count = _count;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }
}
