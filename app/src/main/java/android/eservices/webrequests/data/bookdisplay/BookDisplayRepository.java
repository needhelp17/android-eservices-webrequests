package android.eservices.webrequests.data.bookdisplay;

import android.eservices.webrequests.data.api.model.BookSearchResponse;

import java.util.List;

import io.reactivex.Completable;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface BookDisplayRepository {

    Single<BookSearchResponse> getBookSearchResponse(String s);

}