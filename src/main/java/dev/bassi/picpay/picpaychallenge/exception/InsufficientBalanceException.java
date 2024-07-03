package dev.bassi.picpay.picpaychallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufficientBalanceException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Insufficient balance.");
        problemDetail.setDetail("You cannot transfer an amount greater than your balance.");
        return problemDetail;
    }

}
