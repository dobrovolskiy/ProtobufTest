package com.blogpost.happygilmor89.protobuf.tokenizer;

import com.blogpost.happygilmor89.protobuf.tutoral.AddressBookProtos;
import com.google.protobuf.Descriptors;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by HG89 on 14.12.2014.
 */
public class Tokenizer {
    public static Set<Descriptors.FieldDescriptor> tokenize(com.google.protobuf.GeneratedMessage.Builder builder) {

        Set<Descriptors.FieldDescriptor> descriptorSet = new HashSet<Descriptors.FieldDescriptor>();
        Descriptors.FileDescriptor file = builder.getDescriptorForType().getFile();
        for (Descriptors.Descriptor descriptor : file.getMessageTypes()) {
            for (Descriptors.FieldDescriptor fieldDescriptor : descriptor.getFields()) {
                System.out.print("Name " + fieldDescriptor.getName());
                System.out.print("; Type " + fieldDescriptor.getType());
                System.out.print("; Repeated " + fieldDescriptor.isRepeated());
                descriptorSet.add(fieldDescriptor);
                System.out.println();
            }
        }
        return descriptorSet;
    }

    public static String tokenize(Descriptors.FieldDescriptor descriptor) {
        return descriptor.getName() + " ";
    }

    public static void main(String[] args) {
        tokenize(AddressBookProtos.AddressBook.newBuilder());
    }
}
