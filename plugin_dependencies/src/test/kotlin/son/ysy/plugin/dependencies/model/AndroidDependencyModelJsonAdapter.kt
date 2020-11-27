// Code generated by moshi-kotlin-codegen. Do not edit.
package son.ysy.plugin.dependencies.model

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.internal.Util
import java.lang.NullPointerException
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.emptySet
import kotlin.text.buildString
import son.ysy.plugin.dependencies.model.group.GroupDependency
import son.ysy.plugin.dependencies.model.single.SingleDependency

@Suppress("DEPRECATION", "unused", "ClassName", "REDUNDANT_PROJECTION", "RedundantExplicitType",
    "LocalVariableName")
class AndroidDependencyModelJsonAdapter(
  moshi: Moshi
) : JsonAdapter<AndroidDependencyModel>() {
  private val options: JsonReader.Options = JsonReader.Options.of("version", "single", "group",
      "view", "test")

  private val stringAdapter: JsonAdapter<String> = moshi.adapter(String::class.java, emptySet(),
      "version")

  private val listOfSingleDependencyAdapter: JsonAdapter<List<SingleDependency>> =
      moshi.adapter(Types.newParameterizedType(List::class.java, SingleDependency::class.java),
      emptySet(), "single")

  private val listOfGroupDependencyAdapter: JsonAdapter<List<GroupDependency>> =
      moshi.adapter(Types.newParameterizedType(List::class.java, GroupDependency::class.java),
      emptySet(), "group")

  override fun toString(): String = buildString(44) {
      append("GeneratedJsonAdapter(").append("AndroidDependencyModel").append(')') }

  override fun fromJson(reader: JsonReader): AndroidDependencyModel {
    var version: String? = null
    var single: List<SingleDependency>? = null
    var group: List<GroupDependency>? = null
    var view: List<SingleDependency>? = null
    var test: List<SingleDependency>? = null
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> version = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("version",
            "version", reader)
        1 -> single = listOfSingleDependencyAdapter.fromJson(reader) ?:
            throw Util.unexpectedNull("single", "single", reader)
        2 -> group = listOfGroupDependencyAdapter.fromJson(reader) ?:
            throw Util.unexpectedNull("group", "group", reader)
        3 -> view = listOfSingleDependencyAdapter.fromJson(reader) ?:
            throw Util.unexpectedNull("view", "view", reader)
        4 -> test = listOfSingleDependencyAdapter.fromJson(reader) ?:
            throw Util.unexpectedNull("test", "test", reader)
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    return AndroidDependencyModel(
        version = version ?: throw Util.missingProperty("version", "version", reader),
        single = single ?: throw Util.missingProperty("single", "single", reader),
        group = group ?: throw Util.missingProperty("group", "group", reader),
        view = view ?: throw Util.missingProperty("view", "view", reader),
        test = test ?: throw Util.missingProperty("test", "test", reader)
    )
  }

  override fun toJson(writer: JsonWriter, value: AndroidDependencyModel?) {
    if (value == null) {
      throw NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("version")
    stringAdapter.toJson(writer, value.version)
    writer.name("single")
    listOfSingleDependencyAdapter.toJson(writer, value.single)
    writer.name("group")
    listOfGroupDependencyAdapter.toJson(writer, value.group)
    writer.name("view")
    listOfSingleDependencyAdapter.toJson(writer, value.view)
    writer.name("test")
    listOfSingleDependencyAdapter.toJson(writer, value.test)
    writer.endObject()
  }
}