package com.blogpost.happygilmor89.protobuf.tokenizer;

import com.blogpost.happygilmor89.protobuf.tutoral.AddressBookProtos;
import com.google.protobuf.Descriptors;

import java.util.Map;
import java.util.Objects;

/**
 * Created by HG89 on 14.12.2014.
 */
public class Tokenizer {
    public static String tokenize(com.google.protobuf.GeneratedMessage.Builder builder) {

        Descriptors.Descriptor descriptorForType = builder.getDescriptorForType();
        System.out.println("===Fields: ");
        for (Descriptors.FieldDescriptor fieldDescriptor : descriptorForType.getFields()) {
            System.out.println(fieldDescriptor.getFullName());
        }

        System.out.println("===Extensions: ");
        for (Descriptors.FieldDescriptor extension : descriptorForType.getExtensions()) {
            System.out.println(extension.getFullName());
        }

        System.out.println("===EnumDescriptors: ");
        for (Descriptors.EnumDescriptor enumDescriptor: descriptorForType.getEnumTypes()) {
            System.out.println(enumDescriptor.getFullName());
        }

        return null;
    }

    public static void main(String[] args) {
        tokenize(AddressBookProtos.AddressBook.newBuilder());
    }
}
