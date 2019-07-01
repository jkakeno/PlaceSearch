package com.junkakeno.placesearch.Model;

import com.junkakeno.placesearch.Model.Detail.Detail;
import com.junkakeno.placesearch.Model.Tips.Tips;

public class DetailAndTips {
    Detail detail;
    Tips tips;

    public DetailAndTips(Detail detail, Tips tips) {
        this.detail = detail;
        this.tips = tips;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Tips getTips() {
        return tips;
    }

    public void setTips(Tips tips) {
        this.tips = tips;
    }
}
