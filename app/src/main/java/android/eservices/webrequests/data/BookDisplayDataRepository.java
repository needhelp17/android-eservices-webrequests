package android.eservices.webrequests.data;

import android.eservices.webrequests.BookApplication;
import android.eservices.webrequests.data.api.model.BookSearchResponse;
import android.eservices.webrequests.data.bookdisplay.BookDisplayRepository;
import android.eservices.webrequests.data.bookdisplay.BookDisplayService;
import android.eservices.webrequests.data.di.FakeDependencyInjection;

import io.reactivex.Single;

public class BookDisplayDataRepository implements BookDisplayRepository {

    private final BookDisplayService bookDisplayService;

    public BookDisplayDataRepository(BookDisplayService s){
        this.bookDisplayService = s;
    }
    @Override
    public Single<BookSearchResponse> getBookSearchResponse(String s) {
        return bookDisplayService.searchBooks(s, BookApplication.API_KEY);
    }
}
