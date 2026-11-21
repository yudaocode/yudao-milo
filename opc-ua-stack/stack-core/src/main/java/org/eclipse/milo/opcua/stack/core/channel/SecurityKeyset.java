/*
 * Copyright (c) 2026 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.channel;

/**
 * An immutable snapshot of the symmetric keyset derived during an OpenSecureChannel handshake,
 * suitable for writing to a Wireshark OPC UA key log file.
 *
 * @param channelId the SecureChannelId (unsigned 32-bit, carried as long).
 * @param tokenId the SecurityTokenId (unsigned 32-bit, carried as long).
 * @param clientEncryptionKey the client-to-server AES encryption key.
 * @param clientInitializationVector the client-to-server initialization vector.
 * @param serverEncryptionKey the server-to-client AES encryption key.
 * @param serverInitializationVector the server-to-client initialization vector.
 * @param signatureSize the HMAC output length in bytes (20 for SHA-1, 32 for SHA-256).
 */
public final class SecurityKeyset {
  private final long channelId;
  private final long tokenId;
  private final byte[] clientEncryptionKey;
  private final byte[] clientInitializationVector;
  private final byte[] serverEncryptionKey;
  private final byte[] serverInitializationVector;
  private final int signatureSize;

  public long channelId() {
    return channelId;
  }

  public long tokenId() {
    return tokenId;
  }

  public int signatureSize() {
    return signatureSize;
  }

  public SecurityKeyset(long channelId, long tokenId, byte[] clientEncryptionKey, byte[] clientInitializationVector, byte[] serverEncryptionKey, byte[] serverInitializationVector, int signatureSize) {
  this.channelId = channelId;
  this.tokenId = tokenId;
  this.clientEncryptionKey = clientEncryptionKey.clone();
  this.clientInitializationVector = clientInitializationVector.clone();
  this.serverEncryptionKey = serverEncryptionKey.clone();
  this.serverInitializationVector = serverInitializationVector.clone();
  this.signatureSize = signatureSize;
  }

  public byte[] clientEncryptionKey() {
    return clientEncryptionKey.clone();
  }

  public byte[] clientInitializationVector() {
    return clientInitializationVector.clone();
  }

  public byte[] serverEncryptionKey() {
    return serverEncryptionKey.clone();
  }

  public byte[] serverInitializationVector() {
    return serverInitializationVector.clone();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SecurityKeyset)) return false;
    SecurityKeyset other = (SecurityKeyset) o;
    return java.util.Objects.equals(channelId, other.channelId) && java.util.Objects.equals(tokenId, other.tokenId) && java.util.Objects.equals(clientEncryptionKey, other.clientEncryptionKey) && java.util.Objects.equals(clientInitializationVector, other.clientInitializationVector) && java.util.Objects.equals(serverEncryptionKey, other.serverEncryptionKey) && java.util.Objects.equals(serverInitializationVector, other.serverInitializationVector) && java.util.Objects.equals(signatureSize, other.signatureSize);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(channelId, tokenId, clientEncryptionKey, clientInitializationVector, serverEncryptionKey, serverInitializationVector, signatureSize);
  }

  @Override
  public String toString() {
    return "SecurityKeyset[" + channelId + ", " + tokenId + ", " + clientEncryptionKey + ", " + clientInitializationVector + ", " + serverEncryptionKey + ", " + serverInitializationVector + ", " + signatureSize + "]";
  }
}
