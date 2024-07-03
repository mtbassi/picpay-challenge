package dev.bassi.picpay.picpaychallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UnauthorizedTransactionException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Unauthorized transaction.");
        problemDetail.setDetail("Authorizing service rejected the transaction. Try again.");
        return problemDetail;
    }

}
