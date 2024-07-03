package dev.bassi.picpay.picpaychallenge.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

@AllArgsConstructor
public class WalletNotFoundException extends PicPayException {

    private final Long walletId;

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Wallet not found.");
        problemDetail.setDetail("There is no wallet with id " + walletId + ".");
        return problemDetail;
    }

}
