package android.eservices.webrequests.data.bookdisplay;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookDisplayService {

        @GET("volumes")
        Single<BookSearchResponse> searchBooks(@Query("q") String name, @Query("key") String key);
}
