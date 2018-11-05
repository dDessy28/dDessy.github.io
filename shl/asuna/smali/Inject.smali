.class public Lorg/chall_reverse_android/Inject;
.super Ljava/lang/Object;
.source "Inject.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static SHL(Landroid/content/Context;)V
    .registers 6

    .prologue
    .line 18
    new-instance v0, Lorg/chall_reverse_android/str_pertama;

    invoke-direct {v0}, Lorg/chall_reverse_android/str_pertama;-><init>()V

    .line 19
    new-instance v1, Lorg/chall_reverse_android/str_kedua;

    invoke-direct {v1}, Lorg/chall_reverse_android/str_kedua;-><init>()V

    .line 20
    new-instance v2, Lorg/chall_reverse_android/str_ketiga;

    invoke-direct {v2}, Lorg/chall_reverse_android/str_ketiga;-><init>()V

    .line 21
    new-instance v3, Lorg/chall_reverse_android/secret_flag;

    invoke-direct {v3}, Lorg/chall_reverse_android/secret_flag;-><init>()V

    .line 22
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Lorg/chall_reverse_android/str_pertama;->generateFlag()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v4, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lorg/chall_reverse_android/str_kedua;->StringAnu()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, v3, Lorg/chall_reverse_android/secret_flag;->asuna:[C

    invoke-static {v1}, Ljava/lang/String;->valueOf([C)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v2}, Lorg/chall_reverse_android/str_ketiga;->test()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 23
    invoke-static {p0, v0}, Lorg/chall_reverse_android/Alert;->build(Landroid/content/Context;Ljava/lang/String;)V

    .line 24
    const-string v1, "SHLFlag"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 25
    return-void
.end method
