.class public Lorg/chall_reverse_android/LoadMe;
.super Ljava/lang/Object;
.source "LoadMe.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getKey(Landroid/content/Context;)V
    .registers 5

    .prologue
    .line 18
    new-instance v0, Lorg/chall_reverse_android/challenges;

    invoke-direct {v0}, Lorg/chall_reverse_android/challenges;-><init>()V

    .line 19
    new-instance v1, Lorg/chall_reverse_android/secret_flag;

    invoke-direct {v1}, Lorg/chall_reverse_android/secret_flag;-><init>()V

    .line 20
    invoke-virtual {v0}, Lorg/chall_reverse_android/challenges;->anu()Ljava/lang/String;

    move-result-object v0

    .line 21
    iget-object v1, v1, Lorg/chall_reverse_android/secret_flag;->asuna:[C

    invoke-static {v1}, Ljava/lang/String;->valueOf([C)Ljava/lang/String;

    move-result-object v1

    .line 23
    :try_start_14
    new-instance v2, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    const/4 v3, 0x0

    invoke-static {v0, v3}, Landroid/util/Base64;->decode([BI)[B

    move-result-object v0

    const-string v3, "UTF-8"

    invoke-direct {v2, v0, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    .line 24
    const-string v0, "*REDACTED*"

    invoke-virtual {v2, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 25
    invoke-static {p0, v0}, Lorg/chall_reverse_android/Alert;->build(Landroid/content/Context;Ljava/lang/String;)V

    .line 26
    const-string v1, "SHLFlag2"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_32
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_14 .. :try_end_32} :catch_33

    .line 30
    :goto_32
    return-void

    .line 27
    :catch_33
    move-exception v0

    .line 28
    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    goto :goto_32
.end method
