/*
 * Druid - a distributed column store.
 * Copyright (C) 2012, 2013  Metamarkets Group Inc.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package io.druid.indexer.partitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.druid.indexer.DetermineHashedPartitionsJob;
import io.druid.indexer.HadoopDruidIndexerConfig;
import io.druid.indexer.Jobby;

import javax.annotation.Nullable;

public class RandomPartitionsSpec extends AbstractPartitionsSpec
{
  @JsonCreator
  public RandomPartitionsSpec(
      @JsonProperty("targetPartitionSize") @Nullable Long targetPartitionSize,
      @JsonProperty("maxPartitionSize") @Nullable Long maxPartitionSize,
      @JsonProperty("assumeGrouped") @Nullable Boolean assumeGrouped
  )
  {
    super(targetPartitionSize, maxPartitionSize, assumeGrouped);
  }

  @Override
  public Jobby getPartitionJob(HadoopDruidIndexerConfig config)
  {
    return new DetermineHashedPartitionsJob(config);
  }
}
